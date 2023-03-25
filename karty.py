"""
Napisz program którego zadaniem bedzie sortowanie kart.
Poprzez karty rozumiemy znaki w postaci cyfr 2,3, .. 9
oraz litery J,Q,K,A. Program ma za zadanie wczytac ciąg
znaków oznaczających karty trzymane w ręku oraz wypisać
ten ciąg w postaci posortowanej od najsłabszej do 
najsilniejszej karty.
"""


cards = input("Podaj ciąg znaków reprezentujących karty trzymane w ręku (np. 'A23456789JQK'): ")
cards=cards.upper()
cards_dict = {'2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, 'J': 11, 'Q': 12, 'K': 13, 'A': 14}

# Zamiana ciągu znaków na listę liczb odpowiadających wartościom kart
cards_values = [cards_dict[card] for card in cards]

# Sortowanie listy metodą nąmbelkową bo jaką inną XD?


def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

sorted_array = bubble_sort(cards_values)



# Zamiana listy liczb na listę kart
sorted_cards = [key for key, value in cards_dict.items() if value in cards_values]

#wyświetla gotowe
print("Posortowane karty:", "".join(sorted_cards))

