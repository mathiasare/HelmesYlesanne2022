const API_URL = "https://formsubmit.co/your@email.com";

export const submitForm = (e) => {
  e.preventDefault();
  fetch(`${API_URL}`, {
    method: "POST",
    body: new FormData(e.target),
  }).then(function (response) {
    console.log(response);
  });
};


