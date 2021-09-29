def exchangeOddEven(x):
    return (x & 0xaaaaaaaa) >> 1 | (x & 0x55555555) << 1


print(exchangeOddEven(585))
print(exchangeOddEven(1267650600228229401496703205375))
