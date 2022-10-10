import React, { Component } from 'react';
import './App.css';
import {getAllStudents} from './client';
import {Container} from './Container';
import Footer from './Footer';
import { LoadingOutlined } from '@ant-design/icons';
import AddStudentForm from './forms/AddStudentForm';
import { errorNotification } from './Notification';
import {
  Avatar,
  Table,
  Spin,
  Modal,
  Empty
} from 'antd';

const getIndicatorIcon = () => { 
  return (
    <LoadingOutlined style={{ fontSize: 24 }} spin />
  )
}

class App extends Component {

  state = {
    students: [],
    isFetching: false,
    isAddStudentModelVisible: false
  }

  componentDidMount() {
    this.fetchStudents();
  }

  openAddStudentModelVisible = () => this.setState({isAddStudentModelVisible: true})

  closeAddStudentModelVisible = () => this.setState({isAddStudentModelVisible: false})


  fetchStudents = () => {
    this.setState({
      isFetching: true
    });
    getAllStudents().
      then(res => res.json().
        then(students => {
          this.setState({
            students,
            isFetching: false
          });
      })).catch((error) => {
        console.log(error.error); /* DEV ENV ONLY */
        const message = error.error.message;
        const description = error.error.error;
        errorNotification(message, description);

        this.setState({
          isFetching: false
        });
      });
  }

  render() {
    const { students, isFetching, isAddStudentModelVisible } = this.state;

    const commonElements = () => (
      <div>
        <Modal title="Add new student" open={isAddStudentModelVisible} 
              onOk={this.closeAddStudentModelVisible} 
              onCancel={this.closeAddStudentModelVisible}
              width={1000}>  
              <AddStudentForm 
                onSuccess={() => {
                  this.closeAddStudentModelVisible();
                  this.fetchStudents();  
                }}
                onFailure={(error) => {
                  errorNotification(error.response.statusText, error.error.message);
                  this.closeAddStudentModelVisible();
                }}
              />
        </Modal>
        <Footer numberOfStudents={students.length}
                handleAddStudentClickEvent={this.openAddStudentModelVisible}/>
      </div>
    )

    if (isFetching) {
      return (
        <Container>
          <Spin indicator={getIndicatorIcon()}/>
        </Container>
      );
    }

    if (students && students.length) {
      
      const columns = [
        {
          title: '',
          key: 'avatar',
          render: (text, student) => (
            <Avatar size='large'>
              {`
              ${student.firstName.charAt(0).toUpperCase()} 
              ${student.lastName.charAt(0).toUpperCase()}
              `}
            </Avatar>
          )
        },
        {
          title: 'Student Id',
          dataIndex: 'studentId',
          key: 'studentId'
        },
        {
          title: 'First Name',
          dataIndex: 'firstName',
          key: 'firstName'
        },
        {
          title: 'Last Name',
          dataIndex: 'lastName',
          key: 'lastName'
        },
        {
          title: 'Email',
          dataIndex: 'email',
          key: 'email'
        },
        {
          title: 'Gender',
          dataIndex: 'gender',
          key: 'gender'
        }
      ];

      return (
        <Container>
          <Table
            dataSource={students} 
            columns={columns}
            pagination={false}
            rowKey='studentId'/>
          {commonElements()}
        </Container>
      );
    }

    return (
    <Container>
      <Empty description={
            <h1>No Students Found</h1>
      }/>
      {commonElements()}
    </Container>
    )
  }

}

export default App;
