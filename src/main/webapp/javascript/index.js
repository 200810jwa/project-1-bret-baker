// async function sendLogin(e) {
//   let usernameInput = document.getElementById("username");
//   let passwordInput = document.getElementById("password");

//   try {
//     let response = await fetch("http://localhost:8080/project-1-bret-baker/login", {
//       method: 'POST',
//       credentials: 'include',
//       body: JSON.stringify({
//         username: usernameInput.value,
//         password: passwordInput.value
//       })
//     });

//     sessionStorage.setItem("currentUser", JSON.stringify(await response.json()));
//     // Navigate to profile page
//     // window.location.href = "http://localhost:8080/project-1-bret-baker/";
//   } catch(error) {
//     // Failed to login
//     console.log(error);
//     alert("Failed to login");
//   }
// }