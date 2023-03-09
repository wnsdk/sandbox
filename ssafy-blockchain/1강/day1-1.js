const EC = require("elliptic").ec; // 타원 곡선 알고리즘을 지원하는 라이브러리
const ec = new EC("secp256k1"); // Keccak-256을 지원하는 외부 알고리즘
const { keccak256 } = require("web3-utils");

const privateKey =
  "f8f8a2f43c8376ccb0871305060d7b27b0554d2cc72bccf41b2705608452f315"; // 주어진 개인키
const key = ec.keyFromPrivate(privateKey); // 타원 곡선 위의 점 x, y 구하기
const publicKey = key.getPublic().encode("hex"); // x, y를 이용하여 공개키 구하기
// 타원곡선을 이용하여 얻어낸 key의 접두사 04가 붙어있음
console.log("public key:");
console.log(publicKey);

const K = "0x" + publicKey.slice(2); // 앞의 04를 제거
// ethereum 주소의 prefix 0x
var address = "0x" + keccak256(K).slice(26); // keccak 해시값의 뒤 20바이트만
console.log("address:");
console.log(address);
