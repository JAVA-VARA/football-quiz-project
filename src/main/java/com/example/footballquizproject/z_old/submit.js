function handleKeyPress(event) {
    // 이벤트의 키 코드가 13이면(엔터 키)
    if (event.keyCode === 13) {
        // checkAnswer() 함수 호출
        checkAnswer();
    }
}

