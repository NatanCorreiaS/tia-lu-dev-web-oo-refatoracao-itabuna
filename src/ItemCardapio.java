public class ItemCardapio {

       private int id;
       private String nomedoprato;
       private double preco;


        //construtor
        public ItemCardapio(int id, String nomedoprato, double preco){
            this.id = id;
            this.nomedoprato = nomedoprato;
            this.preco = preco;
        }

        //get e set
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNomedoprato() {
            return nomedoprato;
        }

        public void setNomedoprato(String nomedoprato) {
            this.nomedoprato = nomedoprato;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public ItemCardapio() {
            super();
        }

        public String exibirItem() {
            return "ID: " + id + "|" + nomedoprato + " - R$ " + preco;
        }


    }


