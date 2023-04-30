import { useState } from "react";

function App() {
  const [toDo, setTodo] = useState("");
  const [toDos, setTodos] = useState([]);

  const onChange = (e) => {
    setTodo(e.target.value);
    console.log(toDo);
  }
  
  const onSubmit = (e) => {
    e.preventDefault();
    // 공백 값 입력 방지
    if(toDo === "") {
      return ;
    }
    setTodos((currentArray) => [toDo, ...currentArray]);
    setTodo("");
  }
  
  return (
    <div>
      <h1>My To-do List</h1>
      <form onSubmit={onSubmit}>
        <p>투두 등록하기</p>
        <input type = "text" placeholder="계획을 입력하세요." onChange = {onChange}/>
        <button>등록</button>
      </form>
      <ul>
        {toDos.map((item, index) => <li key = {index}>{item}</li>)}
      </ul>
    </div>
  );
}
export default App;
