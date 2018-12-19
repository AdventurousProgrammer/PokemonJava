#! python3
import requests, os, bs4

url = 'https://pokemondb.net/pokedex/all'
#download the page
res = requests.get(url)
res.raise_for_status()

soup = bs4.BeautifulSoup(res.text,'lxml')

#find the pokemon name, type, and stats for each pokemon

#first getting the pokemon name
#the pokemon name has the class ent-name and the a attribute, beneath td attribute with class cell-name
pokemon_names = soup.select('td.cell-name > a.ent-name')

#print('First pokemon with html code: ' + str(pokemon_names[0]))
#print('First pokemon in pokedex: ' + pokemon_names[0].getText())
#print('Verify if all pokemon are actually pokemon')

#for i in range(0,25):
#    print('Pokemon ' + str(i) + ' ' + pokemon_names[i].getText())
# works as intended for pokemon in pokemon_names:
#    print('Pokemon: ' + pokemon.getText()) 
pokemon_types = soup.select('td.cell-icon')
#print('First pokemon type with html code: ' + str(pokemon_types[0]))
#print('Pokemon with type ' + pokemon_types[0].getText())
pokemon_stats = soup.select('td.cell-num')
print(type(pokemon_stats))
#syntax start,stop,step
#outer for loop that loops over all pokemon
#get the pokemon name, get the pokemon type
stats_index = 1
pokemon_file = open('pokemon_file.txt','w')

for i in range(0,len(pokemon_names)-1):

    pokemon_name = pokemon_names[i].getText()
    pokemon_type = pokemon_types[i].getText()

    for i in range(stats_index,stats_index+6,6):

        if stats_index > len(pokemon_stats) - 1:
            break
        pokemon_file.write('Pokemon: ' + pokemon_name + ' Type(s): ' + pokemon_type + ' HP: ' + str(pokemon_stats[i].getText()) + ' Attack: ' + str(pokemon_stats[i+1].getText()) + ' Defense: ' + str(        pokemon_stats[i+2        ].getText()) + ' Special Attack: '+ str(pokemon_stats[i+3].getText()) + ' Special Defense: ' + str(pokemon_stats[i+4].getText()) + ' Speed: ' + str(pokemon_stats[i+5         ].getText()) + '\n')       
        stats_index+=7 
pokemon_file.close()
print('Done with all pokemon') 
    
         
