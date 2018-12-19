#! python3
import requests, bs4, os

url = 'https://pokemondb.net/move/all'
res = requests.get(url)
res.raise_for_status()

soup = bs4.BeautifulSoup(res.text,'lxml')
attacks_file = open('attack_file.txt','w')
pokemon_attacks = soup.select('tr')
#print('HTML String for second pokemon attack '+ str(pokemon_attacks[1]))

#get effects for pokemon attacks
attack_effects = soup.select('td.cell-long-text')
attack_damage = soup.select('td.cell-num')
#print('Attack effect: '+ attack_effects[1].getText())
attack_types = soup.select('td.cell-icon > a')
attack_damage_index = 0
#for attack in pokemon_attacks:
#    print('Attack: ' + attack.getText())
#print('Number of pokemon attacks: ' + str(len(pokemon_attacks)))
#print('Number of pokemon attack categories: ' + str(len(pokemon_attack_category)))
#print('Number of pokemon attack effects: ' + str(len(attack_effects)))
#print('Number of pokemon attack damages: ' + str(len(attack_damage)))
#print('Number of pokemon attack types: ' + str(len(attack_types)))

for i in range(2,len(pokemon_attacks)):

    #for each attack
    attack = pokemon_attacks[i]
    attack_info = list(attack.descendants)
    #only works when size is 27
    print('Attack String: ' + str(attack)) 
    for i in range(0,len(attack_info)):
        if i == 0:
           print('Type of attack element: '+ str(type(attack_info[i])))
        if '<td class="cell-long-text">' in str(attack_info[i]):
           attack_effect = attack_info[i+1]
        print(str(i) + ' ' + str(attack_info[i])) 
    #the important indices are as follows
    #3- to get attack name
    pok_attack = str(attack_info[3]) 
    attack_type = str(attack_info[6])
    attack_category = str(attack.contents[3].get('data-sort-value'))
    attack_power = str(attack_info[11])
    attack_accuracy = str(attack_info[14])
#    print('Attack: ' + pok_attack)
#    print('Attack accuracy: ' + attack_accuracy)
#    print('-')
#    print('Attack power: ' + attack_power)
#    print('-')
    if attack_accuracy == '—':
        attack_accuracy = 'N/A'
    if attack_power == '—':
        attack_power = 'N/A'
    #attack_effect = str(attack_info[22 + len(attack_info) - 27])
    
    attacks_file.write(' Attack: ' + pok_attack + ' Category: ' + attack_category + ' Type: ' + attack_type +' Damage: ' + attack_power + ' Effect: ' + attack_effect +  ' Accuracy: ' + attack_accuracy + '\n')

 #   attack_damage_index+=3
attacks_file.close()
print('DONE')
    
