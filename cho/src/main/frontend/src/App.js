// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Hello from "./component/Hello";
import Welcome from "./component/Welcome";

function App() {
  const [hello, setHello] = useState('');
  const name = "Jayri";
  const naver = {
    name: "네이버",
    url: "https://naver.com",
  };

  useEffect(() => {
      console.log("did it work?");
    axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
  }, []);

  return (
      <div className="App">
         {/* <h1
            style={{
                color: "#1741e0",
                backgroundColor: "#00c4ff"
            }}>
              <p>
                 백엔드에서 가져온 데이터입니다 : {hello}
              </p>
              <p>
                 프론트의 정적 데이터입니다 : {name}
              </p>

              <a href={naver.url}>{naver.name}</a>
          </h1>*/}

          <Welcome />
          <Hello />
      </div>
  );
}

export default App;