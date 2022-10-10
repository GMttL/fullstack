import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    } else {
        let er = new Error(response.statusText);
        er.response = response;
        response.json().then(e => {
            er.error = e;
        });
        return Promise.reject(er);
    }
}

export const getAllStudents = () => 
    fetch('/api/students').then(checkStatus);

export const addNewStudent = student =>  
    fetch('api/students', {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(student)
    }).then(checkStatus);
