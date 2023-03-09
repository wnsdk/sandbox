### chairman의 의미

chairman은 constructor가 실행될 때 msg의 sender 값을 받아서 할당된다.</br>
즉 해당 트랜잭션을 배포한 사람이 자동으로 chairman이 되며,</br>
단어의 의미 그대로 앞으로 진행될 투표의 '장'을 의미하는 듯 하다.</br>

### proposals의 의미

proposals는 Proposal 객체가 담기는 배열이다.</br>
Proposal의 객체에는 byte32 자료형의 name 속성과 unit 자료형의 voteCount 속성이 들어있다.</br>
각각의 사람들이 몇 표씩을 받았는지를 집계한 내용을 담고있는 배열인 듯 하다.</br>
