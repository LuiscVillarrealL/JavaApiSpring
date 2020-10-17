
import bcrypt

archivo = open("dataUserSinCifrado.txt", "r")
f = open("dataUser.txt", "a")


if archivo.mode == 'r':
    contents = archivo.readlines()
    for x in contents:

        res = x.split(' ')

        if len(res) != 14:
            continue
        
        passConComa =   res[12]
        passSinComa = passConComa.translate({ord(i): None for i in ",'" })

        passEncode = passSinComa.encode()

        hashSinComa = bcrypt.hashpw(passEncode, bcrypt.gensalt()).decode()

        hashConComa = "'" + hashSinComa +"',"

        final = x.replace(res[12], hashConComa)

        f.write(final)

        print (final)



     
