// SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.7.0 <0.9.0;

/**
 * Day 4. Base Code for Practice 
 */
contract FundRaising {
    uint public constant MINIMUM_AMOUNT = 1e16; // 최소 모금액 기준 0.01 ether
    uint public fundRaisingCloses;  // 모금 종료 시각
    address payable public beneficiary;     // 모금 수령자
    address[] funders;              // 모금에 참여한 사람들
    mapping(address => uint256) fundValue;


    // duration : 3600(1시간) 기준으로 설정하기
    constructor (uint _duration, address _beneficiary) {
       fundRaisingCloses = block.timestamp + _duration;
       beneficiary = payable(_beneficiary);
    }

    // 모금하기
    function fund() public payable {
        // 최소 모금액 기준을 넘겨야지만 모금에 참여할 수 있다.
        require(msg.value >= MINIMUM_AMOUNT);

        // 지정된 모금 시간 이내에만 참여할 수 있다. 
        require(block.timestamp < fundRaisingCloses);


        // 모금이 완료되면 모금자를 저장한다.
        address funder = msg.sender;
        funders.push(funder);
        fundValue[funder] += msg.value;
    }

    // 현재까지 모금된 금액 확인
    function currentCollection() public view
    returns(uint256) {
       return address(this).balance;
    }

    // 지정된 수령자만 호출할 수 있다.
    modifier onlyBeneficiary {
        require(msg.sender == beneficiary);
        _;
    }

    // 지정된 모금 시간이 끝난 뒤에만 withdraw 할 수 있다. 
    modifier onlyAfterFundCloses {
        require(block.timestamp > fundRaisingCloses);
        _;
    }

    // 수령자에게 컨트랙트가 보유한 이더를 송금한다.
    function withdraw() public payable 
    onlyBeneficiary onlyAfterFundCloses {
       beneficiary.transfer(address(this).balance);
    }

    // 랜덤 funder
    function selectRandomFunder() public view returns(address funder, uint256 value) {
        require(funders.length > 0);
        uint256 random = uint256(keccak256(abi.encodePacked(block.timestamp, block.difficulty))) % funders.length;
        funder = funders[random];
        value = fundValue[funder];
    }

}
