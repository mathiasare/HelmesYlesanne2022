const API_URL = "http://localhost:8080/user";

let USER_ID = -1;

  function makeRequest(event) {
    event.preventDefault();
  
    let data = JSON.stringify(Object.fromEntries(new FormData(event.target)))

    if(USER_ID === -1) {
      url = `${API_URL}/persist`
      method = 'POST'
    } else {
      url = `${API_URL}/update/${USER_ID}`
      method = 'PUT'
    }
    
    fetch(`${url}`, {
      method: `${method}`,
      body: data,
      headers: {
        'Access-Control-Allow-Origin':'*',
        'Content-type': 'application/json'
      }
    }).then(function (response) {
      if (response.ok) {
        response.json().then(responseData => {
          console.log(responseData)
          document.getElementById("name-input").value = responseData.name
          document.getElementById("select-sectors").value = responseData.sector_id
          document.getElementById("terms-checkbox").checked = responseData.agreed_to_terms
          if(USER_ID === -1) {
            USER_ID = responseData.user_id
            document.getElementById("submit-button").innerText = 'Update'
          }
        })
        return response;
      } else {
        return Promise.reject(response);
      }
    }).then(function (data) {
      console.log(data);
    }).catch(function (error) {
      console.warn(error);
    });
  }

  function handleSubmit(event) {
      makeRequest(event)
  }
