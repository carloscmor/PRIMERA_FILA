import json

with open('api.json','r') as f:
    fichero = json.load(f)

with open('salida.txt','w') as s:
    for pregunta in fichero['results']:
        lista = list(pregunta.values())
        for value in lista:
            s.write(''.join(str(value)))
            s.write(';')
        s.write('\n')
