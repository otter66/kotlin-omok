# kotlin-omok

## android 
- [x] 앱을 켤 때
  - [x] 데이터베이스의 돌 위치들을 불러와 배치한다.
- [x] 보드 클릭
  - [x] 좌표를 기록한다.
  - [x] 이미지를 바꾼다.
  - [x] 데이터베이스에 좌표를 기록한다. 
  - [x] 게임이 끝났다면 새로고침 버튼을 노출시킨다.
- [ ] 새로고침 클릭
  - [x] 데이터베이스를 초기화한다.
  - [ ] 보드 뷰를 초기화한다.

---

## 기능 목록 (domain)

data class Position
- [X] x좌표와 y좌표를 알고 있다.
- [X] x좌표는 1이상 15이하의 값을 가진다.
- [X] y좌표는 1이상 15이하의 값을 가진다.
---
enum StoneType
- [x] BLACK, WHITE, EMPTY를 가진다.
Stone
- [x] 자신의 위치와 스톤 타입을 가진다.
class Stones
- [x] 스톤들의 정보를 담고 있다.
- [x] 스톤을 받아 추가한다.
- [x] 스톤을 받아 해당 스톤의 위치에 돌이 놓여져있는지 확인한다.
- [x] 스톤들을 받아서 두 스톤들을 더한 값을 반환한다.
- [x] 돌들의 위치를 board에 표시해 반환한다.
-
---
interface State
- [x] put(): State
- [x] getWinner(): StoneType
- [x] isValidPut(): Boolean
- [x] isOmokCondition(): Boolean
abstract Running(stones) : State   
- [x] isValidPut(): Boolean { }
- [x] 오목 조건을 충족하는지 확인한다.
WhiteTurn : Running
- [x] stone을 추가할 수 없는 상태라면 추가하지 않고 WhiteTurn을 반환
- [x] stone를 추가한 후 BlackTurn을 반환
- [x] 오목 조건 충족하면 End 상태로 White가 Win
BlackTurn : Running
- [x] stone을 추가할 수 없는 상태라면 추가하지 않고 BlackTurn을 반환
- [x] stone를 추가한 후 WhitTurn를 반환
- [x] 오목 조건 충족하면 End 상태로 Black이 Win
End : State
- [x] 우승자에 해당하는 StoneType을 가진다.
- [x] 우승자의 StoneType을 반환한다.
---
interface OmokRule
- [x] 오목 조건을 충족하는지 확인한다.
- [x] 오목 돌을 놓을 수 있는 위치인지 확인한다.
RenjuOmokRule(board: Board): OmokRule
---
Board
- [x] 게임 턴의 상태를 가진다.
---
InputView
- [X] 위치를 입력받는다.
OutputView
- [X] 흑돌들과 백돌들을 받아서 바둑판 위에 출력한다.
- [x] 누구 차례인지 출력한다.
- [x] 마지막 돌의 위치를 출력한다.
- [x] 누가 승리했는지 출력한다.(black이면 흑 white면 백)


---
찝찝한 것
- [ ] 모든 상태들이 크게 차이가 없는 두 돌인 흑돌과 백돌을 따로 받는다. -> Stones가 백돌을 흑돌을 가지게 해서 프로퍼티가 3개로 고칠 수 있지만 요구사항에 맞지 않음