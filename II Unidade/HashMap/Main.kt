fun main() {
    val c1 = Cliente("Ana Clara", 25)
    val c2 = Cliente("Pedro Henrique", 18)
    val c3 = Cliente("Beatriz Oliveira", 30)
    val c4 = Cliente("Rafaela Costa", 22)
    val c5 = Cliente("Lucas Santos", 35)
    val c6 = Cliente("Mariana Silva", 40)


    var espalhavel: Espalhavel = MapaEspalhamento(26)
    espalhavel.adicionar(Mapa("ana", c1))
    espalhavel.adicionar(Mapa("pedro", c2))
    espalhavel.adicionar(Mapa("beatriz", c3))
    espalhavel.adicionar(Mapa("rafaela", c4))
    espalhavel.adicionar(Mapa("lucas", c5))
    espalhavel.adicionar(Mapa("mariana", c6))


    var chave = "ana"
    val clienteTemp = espalhavel.buscar(chave) as Cliente
    println("A idade de $chave é: ${clienteTemp.idade}")


    chave = "beatriz"
    if (espalhavel.contemChave(chave))
        println("Contém a chave $chave, referenciando o objeto ${espalhavel.buscar(chave)}")
    else
        println("Não contém a chave $chave")

    chave = "jorge"
    if (espalhavel.contemChave(chave))
        println("Contém a chave $chave, referenciando o objeto ${espalhavel.buscar(chave)}")
    else
        println("Não contém a chave $chave")


    espalhavel.remover("beatriz")

    chave = "beatriz"
    if (espalhavel.contemChave(chave))
        println("Contém a chave $chave, referenciando o objeto ${espalhavel.buscar(chave)}")
    else
        println("Não contém a chave $chave")
}
