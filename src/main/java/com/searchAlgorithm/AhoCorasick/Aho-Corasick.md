# 아호-코라식 문자열 매칭 알고리즘

아호-코라식 알고리즘은 여러 키워드를 동시에 빠르게 검색할 수 있는 효율적인 문자열 검색 알고리즘이다. 

이 알고리즘은 트라이 자료구조를 기반으로 하여 키워드들을 사전처럼 처리한 후, 
텍스트를 단 한 번만 스캔하여 모든 키워드를 검출한다.

## 시간 복잡도 및 공간 복잡도

- **시간 복잡도**: **O(n + m + z)**, 여기서 n은 텍스트의 길이, m은 키워드의 총 길이, z는 텍스트 내에서 찾은 키워드의 총 출현 횟수.
- **공간 복잡도**: O(m + k), 여기서 m은 키워드의 총 길이, k는 알파벳의 크기. 트라이 자료구조가 각 키워드의 모든 문자를 노드로 저장하므로, 키워드가 많고 길 경우 상당한 메모리를 사용할 수 있다.

## 트라이 자료구조 예시

다음 단어들을 포함하는 트라이 예시: {"안녕하세요", "안녕히", "안녕히계세요", "안녕", "안경"}

```plaintext
      
      ┌── (안녕)
안 ── 녕 ── 하 ── 세 ── 요 (안녕하세요)
 │    └─── 히 ── 계 ── 세 ── 요 (안녕히계세요)
경 (안경)    └─── (안녕히)
```