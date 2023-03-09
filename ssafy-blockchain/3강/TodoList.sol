// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.8.2 <0.9.0;

contract TodoList {

    struct Todo {
        string title;
        bool isFinished;
    }

    Todo[] public todoList;

    // 할 일 추가
    function addTodoList(string memory todoTitle) public {
        todoList.push(Todo({
            title: todoTitle,
            isFinished: false
        }));
    }

    // 할 일의 제목을 수정
    function modifyTodoTitle(uint index, string memory todoTitle) public {
        todoList[index].title = todoTitle;
    }

    // 할 일의 완료 여부 변경
    function modifyTodoIsFinished(uint index, bool isFinished) public {
        todoList[index].isFinished = isFinished;
    }

    // 할 일의 상세 정보 확인
    function getTodo(uint index) public view returns(Todo memory todo_) {
        todo_ = todoList[index];
    }

    // 할 일의 목록 전체를 제공
    function getTodoList() public view returns(Todo[] memory todoList_) {
        todoList_ = todoList;
    }
}