# Pailndrome

팰린드롬 : 뒤집어서 읽어도 똑같이 읽히는 형태

``` python
def is_palindrome(A, s, e):
    while s < e:
        if A[s+1] != A[e-1] {
            return false
        }
    return true

```
- 시작지점에서 중간지점까지 한 번이라도 비교값이 다르지 않다면 팰린드롬
- 모든 경우를 다 찾아보기 때문에 비효율적

### DP 이용
- 왼쪽 끝과 오른쪽 끝이 같다면, 그 사이의 숫자가 팰린드롬이라면, 이 숫자는 팰린드롬이 된다.
- Bottom Up 방식으로 해결


[출처] https://brenden.tistory.com/27