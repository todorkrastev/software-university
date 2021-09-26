function ticTacToe(input) {

    let dashboard = [[false, false, false],
    [false, false, false],
    [false, false, false]];

    let hasFreeFields = (matrix) => matrix.some((arr) => arr.some(value => value === false))
    let win = false;
    let player = 'X';
    for (let i = 0; i < input.length && hasFreeFields(dashboard); i++) {
        let [row, col] = input[i].split(' ').map(num => Number(num));

        if (!dashboard[row][col]) {
            dashboard[row][col] = player;

            if (checkForWinner(dashboard, player)) {
                win = true;
                break;
            }

            player = player === 'X' ? 'O' : 'X';
        } else {
            console.log("This place is already taken. Please choose another!");
        }

    }

    if (win) {
        console.log(`Player ${player} wins!`);
    } else {
        console.log("The game ended! Nobody wins :(");
    }
    dashboard.forEach(line => {
        console.log(line.join('\t'));
    });

    function checkForWinner(currentBoard, sign) {
        let isWinner = false;
        for (let i = 0; i < 3; i++) {
            if (currentBoard[i][0] === sign && currentBoard[i][1] === sign && currentBoard[i][2] === sign) {
                isWinner = true;
                break;
            }
            if (currentBoard[0][i] === sign && currentBoard[1][i] === sign && currentBoard[2][i] === sign) {
                isWinner = true;
                break;
            }
        }
        if (!isWinner) {
            if ((currentBoard[0][0] === sign && currentBoard[1][1] === sign && currentBoard[2][2] === sign) ||
                (currentBoard[2][0] === sign && currentBoard[1][1] === sign && currentBoard[0][2] === sign)) {
                isWinner = true;
            }
        }
        return isWinner;
    }

    /*   const board = [0, 0, 0].map(x => ["false", "false", "false"])
       let player = "X"
   
       function isWinningMove(board, row, place) {
           // after the move has been made, we -->
           // check current row for 3 equals
           // || reducing to new array with column === the place player is marking.
           //e.g. if player is on place 2 in row 1,
           //we make new array with all places 2 from all 3 rows
           //to check for column equality
           // || adding main diagonal to new array, checking it for equality
           // || adding second diagonal and checking it.
           return (
               board[row].every(x => x === player) ||
               board
                   .reduce((a, v) => {
                       a.push(v[place])
                       return a
                   }, [])
                   .every(x => x === player) ||
               [board[0][0], board[1][1], board[2][2]].every(x => x === player) ||
               [board[0][2], board[1][1], board[2][0]].every(x => x === player)
           )
       }
   
       const printBoard = board => console.log(board.map(x => x.join("\t")).join("\n"))
   
       for (let i = 0; i < arr.length; i++) {
           const [row, place] = arr[i].split(" ").map(Number)
   
           if (board[row][place] !== "false") {
               console.log("This place is already taken. Please choose another!")
               continue
           }
           board[row][place] = player
   
           if (isWinningMove(board, row, place)) {
               console.log(`Player ${player} wins!`)
               printBoard(board)
               break
           }
   
           if (board.every(x => x.every(y => y !== "false"))) {
               console.log("The game ended! Nobody wins :(")
               printBoard(board)
               break
           }
   
           player = player === "X" ? "O" : "X"
       } */
}
