package List.OperaçõesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras(){
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));     
    }
    public void removerItem(String nome){
        List<Item> removeItems = new ArrayList<>();
        if(!itemList.isEmpty()) {
            for(Item i : itemList){
                if(i.getNome().equalsIgnoreCase(nome)){
                removeItems.add(i);
                }
            }
            itemList.removeAll(removeItems);
        }else{
            System.out.println("Lista Vazia");
        }
        
    }
    public double calcularValorTotal(){
        double valorTotal = 0d;
        if(!itemList.isEmpty()){
            for(Item i: itemList){
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
       
        } else {
        throw new RuntimeException("A lista está vazia!");
      }
    }
    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(this.itemList);
        }else{
            System.out.println("Lista Vazia");
        }

    }
    @Override
    public String toString() {
      return "CarrinhoDeCompras{" +
          "itens=" + itemList +
          '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Fone",3d, 3);
        carrinhoDeCompras.adicionarItem("Fone",4d, 9);
        carrinhoDeCompras.adicionarItem("Laptop",5d, 5);
        carrinhoDeCompras.adicionarItem("Celular",6d, 6);
        
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Fone");
        carrinhoDeCompras.exibirItens();

        System.out.println("o total é: " + carrinhoDeCompras.calcularValorTotal());
    }

}
