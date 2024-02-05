let currentInput = '';
let currentOperator = '';
let resultDisplay = document.getElementById('result');

function appendInput(value) {
  currentInput += value;
  updateDisplay();
}

function setOperator(operator) {
  currentOperator = operator;
  appendInput(operator);
}

function calculate() {
  try {
    const result = eval(currentInput);
    currentInput = result.toString();
    updateDisplay();
  } catch (error) {
    currentInput = 'Error';
    updateDisplay();
  }
}

function clearResult() {
  currentInput = '';
  currentOperator = '';
  updateDisplay();
}

function updateDisplay() {
  resultDisplay.value = currentInput;
}

