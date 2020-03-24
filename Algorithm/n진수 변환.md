```python
def recu(num, base):
    table = "0123456789ABCDEF"
    q, r = divmod(num, base)
    if q == 0:
        return table[r]
    else:
        return recu(q, base) + table[r]
```