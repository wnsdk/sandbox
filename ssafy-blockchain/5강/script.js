var web3;
/**
 * 실습 환경에 맞는 값 할당
 */
const SEPOLIA_URL =
  "https://sepolia.infura.io/v3/ccbf710f49e54b2c867e185af221ffa9";
const CA = "0x7aE022cCea6910B3F755FC64F6d6521B6efF327F";
const STORAGE_ABI = [
  {
    inputs: [],
    name: "retrieve",
    outputs: [
      {
        internalType: "uint256",
        name: "",
        type: "uint256",
      },
    ],
    stateMutability: "view",
    type: "function",
  },
  {
    inputs: [
      {
        internalType: "uint256",
        name: "num",
        type: "uint256",
      },
    ],
    name: "store",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
];
const privateKey =
  "b7e377ebc8b72d357580dd6b54f43c37649bf3c9d780d461494b323f4dd0b0dd";
var sender;
var senderAddress;
var storageContract;

/**
 * TODO:
 * web3 객체 만들기
 */
window.addEventListener("load", () => {
  //   if (typeof web3 !== "undefined") {
  //     window.web3 = new Web3(web3.currentProvider);
  //     console.log("web3 injected");
  //   } else {
  //     window.web3 = new Web3(new Web3.providers.HttpProvider(SEPOLIA_URL));
  //   }
  //   console.log("provider");
  //   console.log(window.web3);
  window.web3 = new Web3(new Web3.providers.HttpProvider(SEPOLIA_URL));
  startApp();
});

/**
 * TODO:
 * 계정 정보 생성 및 초기 값 세팅
 */
function startApp() {
  // 1. 계정 정보
  sender = web3.eth.accounts.privateKeyToAccount("0x" + privateKey);
  web3.eth.accounts.wallet.add(sender);
  web3.eth.defaultAccount = sender.address;
  senderAddress = web3.eth.defaultAccount;

  // 2. storage 컨트랙트 인스턴스
  storageContract = new web3.eth.Contract(STORAGE_ABI, CA);

  // 3. 화면에 초기 값 세팅
  document.querySelector("#contractAddr").innerHTML = CA;
  document.querySelector("#accountAddr").innerHTML = senderAddress;
}

/**
 * TODO:
 * retrieve() 함수 호출 후 화면에 결과 표시
 */
function retrieve() {
  console.log(storageContract.methods);
  storageContract.methods
    .retrieve()
    .call({
      from: senderAddress,
    })
    .then((data) => {
      document.querySelector("#storedData").innerHTML = data;
    });
}

/**
 * TODO:
 * store() 함수 호출 후 화면에 결과 표시
 */
function store() {
  var value = document.querySelector("#newValue").value;
  console.log(value);
  storageContract.methods
    .store(value)
    .send({
      from: senderAddress,
      gas: 3000000,
      //   gasPrice: gasPrice,
    })
    .then((data) => {
      document.querySelector("#lastBlock").innerHTML = data.blockNumber;
      document.querySelector("#txHash").innerHTML = data.transactionHash;
    });
}
