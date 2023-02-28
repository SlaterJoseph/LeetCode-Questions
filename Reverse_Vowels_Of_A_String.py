class Solution:
    # Create a set of the vowels
    # Iterate with 2 points, 1 in front and 1 in back
    # When both his a vowel, swap
    # continue
    def reverseVowels(self, s: str) -> str:
        vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}
        s = list(s)
        front = 0
        back = len(s) - 1

        while front <= back:
            if s[front] in vowels and s[back] in vowels:
                s[front], s[back] = s[back], s[front]
                front += 1
                back -= 1
                continue

            if s[front] not in vowels:
                s[front] = s[front]
                front += 1
            if s[back] not in vowels:
                s[back] = s[back]
                back -= 1

        return ''.join(s)
