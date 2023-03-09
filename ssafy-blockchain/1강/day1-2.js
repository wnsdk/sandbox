// web3 라이브러리 로드 및 Ethereum 네트워크에 연결
const Web3 = require("web3");
const Tx = require("ethereumjs-tx");
const web3 = new Web3(
  new Web3.providers.HttpProvider(
    "https://sepolia.infura.io/v3/ccbf710f49e54b2c867e185af221ffa9"
  )
);

// Define transaction parameters
const fromAddress = "0x19020C8DE459be59C3406770520C961DA2fda091"; // sender's address
const toAddress = "0xd42f75671Db05e1E4669CC1CE65e9f05EB6d9B02"; // recipient's address

// 1. nonce 값 조회
web3.eth.getTransactionCount(fromAddress, function (err, nonce) {
  // 2. 트랙잭션 데이터 생성
  const txParams = {
    nonce: web3.utils.toHex(nonce),
    to: toAddress,
    value: web3.utils.toHex(web3.utils.toWei("0.002", "ether")), // 0.1 이더
    gasPrice: web3.utils.toHex(web3.utils.toWei("1", "Gwei")), // 가스 가격
    gasLimit: web3.utils.toHex(300000), // 가스 최대 사용량
    // EIP 155 chainId - mainnet: 1, ropsten: 3
    data: "0x",
  };
  const tx = new Tx(txParams);

  // 3. 트랜잭션 서명
  const privateKey = Buffer.from(
    "b7e377ebc8b72d357580dd6b54f43c37649bf3c9d780d461494b323f4dd0b0dd",
    "hex"
  );
  tx.sign(privateKey);

  // 4. 트랜잭션 전송하기
  const serializedTx = "0x" + tx.serialize().toString("hex");
  web3.eth.sendSignedTransaction(serializedTx, function (err, txId) {
    if (!err) {
      console.log("txId: ", txId); // 트랜잭션ID값
    }
  });
});
