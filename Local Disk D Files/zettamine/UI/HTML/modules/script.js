export let greetings = (myName)=>{
   let val = `Hi, welcome to the js modules ${myName}`
   document.getElementById("main-content").innerText = val
    return val
}