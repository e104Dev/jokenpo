# Tutorial JoKenPo (Papel, Tesoura ou Pedra)

## Recursos
Antes de começar, faça o download das imagens utilizadas no projeto neste [link](https://github.com/e104SysDev/jokenpo/tree/main/app/src/main/res/drawable-v24).

## Step 01 - Criar Projeto
Crie um novo projeto como de costume e lembre-se de escolher a linguagem `Java` e uma `Empty Activity`.

Após o projeto concluir o `build` e baixar as dependências `gradle`, podemos prosseguir.

Crie uma nova `Activity` com o identificador `JogoActivity`, lembre-se clieque com o borão diretito do mouse sobre a pasta `app` e selecione `New/Activity/Empty Activity`

## Step 02 - Incluir os recursos
Adicione as imagens já baixadas previamente e as copie para a pasta `res/drawable` no projeto Android.

## Step 03 - UI
Neste passo iremos criar a Inteface Gráfica do projeto; temos duas telas, a tela pricipal (activity_main) e a tela do jogo (activity_jogo).
O detalhamento da crição das telas estão demonstrados nos vídeos das aula 10 e 11, neste tutorial iremos focar na implementação, então logo abaixo serão listados os códigos completos dos arquivos que compõem a interface gráfica de cadas uma das telas.

### MainActivity
Copie o código abaixo para o arquivo `activity_main.xml`.
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:adjustViewBounds="true"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/jokenpo" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="The Game"
        android:textAppearance="@style/TextAppearance.AppCompat.Display3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayoutContainer"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:hint="Digite o seu nome, jogador..."
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView">

        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/textInputLayoutNome"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/buttonPlay"
        android:layout_width="0dp"
        android:layout_height="60dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:onClick="iniciarJogo"
        android:text="Jogar"
        app:cornerRadius="32dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textInputLayoutContainer" />
</androidx.constraintlayout.widget.ConstraintLayout>

```

### JogoActivity
Copie o código abaixo para o arquivo `activity_jogo.xml`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageViewTesoura"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:onClick="jogar"
        app:layout_constraintEnd_toStartOf="@+id/imageViewPedra"
        app:layout_constraintStart_toEndOf="@+id/imageViewPapel"
        app:layout_constraintTop_toTopOf="@+id/imageViewPedra"
        app:srcCompat="@drawable/tesoura_png" />

    <ImageView
        android:id="@+id/imageViewPedra"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:onClick="jogar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:srcCompat="@drawable/pedra_png" />

    <ImageView
        android:id="@+id/imageViewPapel"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:layout_marginStart="16dp"
        android:layout_marginBottom="16dp"
        android:onClick="jogar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:srcCompat="@drawable/papel_png" />

    <ImageView
        android:id="@+id/imageViewJogador"
        android:layout_width="240dp"
        android:layout_height="240dp"
        android:adjustViewBounds="true"
        android:cropToPadding="false"
        android:scaleType="centerInside"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/voce" />

    <ImageView
        android:id="@+id/imageViewComputador"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_marginTop="16dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/computador_png" />

    <TextView
        android:id="@+id/textViewComputador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Computador"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageViewComputador" />

    <TextView
        android:id="@+id/textViewStatusPartida"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Você"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageViewJogador" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:text="Vitórias"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/imageViewComputador" />

    <TextView
        android:id="@+id/textViewPontosJogador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="@+id/textView4"
        app:layout_constraintTop_toBottomOf="@+id/textView4" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Derrotas"
        app:layout_constraintStart_toStartOf="@+id/textViewPontosJogador"
        app:layout_constraintTop_toBottomOf="@+id/textViewPontosJogador" />

    <TextView
        android:id="@+id/textViewPontosComputador"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="@+id/textView6"
        app:layout_constraintTop_toBottomOf="@+id/textView6" />

    <Button
        android:id="@+id/button"
        style="@style/Widget.MaterialComponents.Button.OutlinedButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:text="Sair"
        android:visibility="gone"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@+id/imageViewComputador" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Empates"
        app:layout_constraintStart_toStartOf="@+id/textViewPontosComputador"
        app:layout_constraintTop_toBottomOf="@+id/textViewPontosComputador" />

    <TextView
        android:id="@+id/textViewEmpates"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="@+id/textView2"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
## Step 04 - Implementando as funcionalidades em Java
Nesta passo iremos implementar as funcionalidades das duas telas utilizando `Java`. 

### Tela Principal

Esta tela tem por objetivo capturar o nome do jogador e inicializar o Jogo.

Iremos capturar o nome do jogador e enviar o nome capturado para a tela do jogo, conforme as instruções abaixo na classe `MainActivity`:

1. Declare um objeto da classe TextInputLayout como global.
```java
TextInputLayout textInputLayout;
```
2. Inicilaize o objeto no método `onCreate()`;
```java
textInputLayout = findViewById(R.id.textInputLayoutContainer);
```
3. Crie a função `iniciarJogo(View view)`, esta função criará um objeto Intent, incluirá o nome do jogador e inicializará a tela de início do jogo.
```java
    public void iniciarJogo(View view) {
        String jogador = Objects.requireNonNull(textInputLayout.getEditText()).getText().toString();
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("nomeJogador", jogador);
        startActivity(intent);
    }
```
4. Confira o código criado:
```java
public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.textInputLayoutContainer);
    }

    public void iniciarJogo(View view) {
        String jogador = Objects.requireNonNull(textInputLayout.getEditText()).getText().toString();
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("nomeJogador", jogador);
        startActivity(intent);
    }
}
```

### Tela do Jogo

Neste passo iremos implementar a lógica aplicada para as interações e processamentos realizados no App.

1. Declare os objetos globais na classe `JogoActivity`.
```java
    // Mapas e listas para facilitar a manipulação das imagens e identificadores das Views
    Map<Integer, Integer> mapImages;
    List<Integer> opcoesComputador, IdsOpcoesComputador;
    
    // Componentes visuais da aplicaçã
    List<Integer> opcoesComputador, IdsOpcoesComputador;o
    ImageView mPapel, mTesoura, mPedra, mComputador, mJogador;
    TextView mPontosJogador, mPontosComputador, mStatusPartida, mPontosEmpate;
    
    // Variáveis para manter dados no App
    String status = "";
    Integer placarJogador = 0, placarComputador = 0, empate = 0;
    Random random = new Random();

```
2. Crie a função para receber o nome do jogador através do método getIntent() e inclua sua chamada no método `onCreate`.
```java
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void alterarTituloAppBar() {
        String nomeJogador = getIntent().getStringExtra("nomeJogador");

        if(Objects.nonNull(nomeJogador) && Boolean.FALSE.equals(nomeJogador.isEmpty())) {
            this.setTitle(nomeJogador.concat(" jogando"));
        }
    }
```
3. Crie uma função para configurar os ImageViews criados e faça uma chamada à este método no `onCreate`.
```java
    private void configurarImageViews() {
        opcoesComputador = Arrays.asList(R.drawable.papel_png, R.drawable.tesoura_png, R.drawable.pedra_png);
        IdsOpcoesComputador = Arrays.asList(R.id.imageViewPapel, R.id.imageViewTesoura, R.id.imageViewPedra);
        mapImages = new HashMap<>();
        mapImages.put(R.id.imageViewPapel, R.drawable.papel_png);
        mapImages.put(R.id.imageViewTesoura, R.drawable.tesoura_png);
        mapImages.put(R.id.imageViewPedra, R.drawable.pedra_png);
        mapImages.put(R.id.imageViewComputador, R.drawable.computador_png);
        mapImages.put(R.id.imageViewJogador, R.drawable.voce);

        mPapel = findViewById(R.id.imageViewPapel);
        mTesoura = findViewById(R.id.imageViewTesoura);
        mPedra = findViewById(R.id.imageViewPedra);

        mComputador = findViewById(R.id.imageViewComputador);
        mJogador = findViewById(R.id.imageViewJogador);

    }
```

4. Crie uma função para configurar os TextViews criados e faça uma chamada à este método no `onCreate`.
```java
    private void configurarTextViews() {
        mPontosJogador = findViewById(R.id.textViewPontosJogador);
        mPontosComputador = findViewById(R.id.textViewPontosComputador);
        mStatusPartida = findViewById(R.id.textViewStatusPartida);
        mPontosEmpate = findViewById(R.id.textViewEmpates);
    }
```
5. Verifique as chamadas no `onCreate`.
```java
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        alterarTituloAppBar();
        configurarImageViews();
        configurarTextViews();

    }
```

#### Implementado a Lógica
Neste ponto, todos os recurso visuais estão configurados e organizados; agora podemos iniciar a `Lógica` do jogo.

1. Crie os Enums `Jogada` e `Status` pra facilitar a manipulação de constantes e a legibilidade, eles serão declarados no nível das funções, verifique a identação do código.
```java
enum Status {
        GANHOU("GANHOU"),
        PERDEU("PERDEU"),
        EMPATOU("EMPATOU");

        private final String status;

        public String getStatus() {
            return status;
        }

        Status(String status) {
            this.status = status;
        }
    }

    enum Jogada {
        PAPEL(R.id.imageViewPapel),
        TESOURA(R.id.imageViewTesoura),
        PEDRA(R.id.imageViewPedra);

        private final int id;

        public int getId() {
            return id;
        }

        Jogada(int id) {
            this.id = id;
        }

        public static Jogada toEnum(int id) {
            for (Jogada jogada: Jogada.values()) {
                if(jogada.getId() == id) return jogada;
            }
            throw new RuntimeException("Id inválido: "+id);
        }
    }
```

2. Crie o método que realiza a jogada do computador, o computador irá sortear um número aleatório entre 0 e 2 e cada um destes valores representará `[Papel, Tesoura, Pedras]`, respectivamente. Esta função realizar a trocas das imagens com base no número aleatório e logo após ela devolve o id o objeto que disparou a função para que possamos reutilizar o retorno com a identificação da jogada realizada.
Adicione o método abaixo:
```java
    public int jogadaComputador() {
        int valorRandomico = random.nextInt(3);
        int idResource = opcoesComputador.get(valorRandomico);
        mComputador.setImageResource(idResource);

        return IdsOpcoesComputador.get(valorRandomico);
    }
```

Neste ponto, sempre que tocar nas imagens Papel, Tesoura ou Pedra a imagem do usuário será alterada, mas a iagem do computador ainda não.
Precisamos crair uma função que execute a jogada do usuário e a jogada do computador, ambas retornam as escolhas realizadas. Precisamos capturar estas escolhas e criar a lógica parav definir o vencedor.

3. Crie a função que realiza as jogadas do usuário e do computador com base na imagem selecionada.
```java
private void definirVendedor(Jogada jogadaUsuario, Jogada jogadaComputador) {

        switch (jogadaUsuario) {
            case PAPEL:
                if (PEDRA.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (TESOURA.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
            case TESOURA:
                if (PAPEL.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (PEDRA.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
            case PEDRA:
                if (TESOURA.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (PAPEL.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
        }
    }
```

4. Adicione o método que atualiza os dados.
```java
    private void atualizaPlacar() {
        mPontosComputador.setText(String.valueOf(placarComputador));
        mPontosJogador.setText(String.valueOf(placarJogador));
        mPontosEmpate.setText(String.valueOf(empate));
        mStatusPartida.setText(status);
    }
```

5. Finalizando o Jogo:
Agora precisamos que uma função realize a jogada do usuário, a jogada do computador, obtenha os valores das jogadas e chame a função que definirá o vencedor.
```java
    public void jogar(View v) {
        Jogada jogador = Jogada.toEnum(jogadaUsuario(v));
        Jogada computador = Jogada.toEnum(jogadaComputador());

        definirVendedor(jogador, computador);
    }
```
6. Toque final. Adicione a chamada da função `atualizarPlacar` na função `definirVencedor`para atualizar os pontos a cada jogada. Adicione-o à penúltima linha do método `definirVencedor`.

#### Confira o código completo teste o App.
```java
public class JogoActivity extends AppCompatActivity {

    Map<Integer, Integer> mapImages;
    List<Integer> opcoesComputador, IdsOpcoesComputador;
    ImageView mPapel, mTesoura, mPedra, mComputador, mJogador;
    Integer placarJogador = 0, placarComputador = 0, empate = 0;

    TextView mPontosJogador, mPontosComputador, mStatusPartida, mPontosEmpate;
    String status = "";
    Random random = new Random();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        alterarTituloAppBar();
        configurarImageViews();
        configurarTextViews();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void alterarTituloAppBar() {
        String nomeJogador = getIntent().getStringExtra("nomeJogador");

        if(Objects.nonNull(nomeJogador) && Boolean.FALSE.equals(nomeJogador.isEmpty())) {
            this.setTitle(nomeJogador.concat(" jogando"));
        }
    }

    private void configurarTextViews() {
        mPontosJogador = findViewById(R.id.textViewPontosJogador);
        mPontosComputador = findViewById(R.id.textViewPontosComputador);
        mStatusPartida = findViewById(R.id.textViewStatusPartida);
        mPontosEmpate = findViewById(R.id.textViewEmpates);
    }

    public void jogar(View v) {
        Jogada jogador = Jogada.toEnum(jogadaUsuario(v));
        Jogada computador = Jogada.toEnum(jogadaComputador());

        definirVendedor(jogador, computador);
    }

    private void definirVendedor(Jogada jogadaUsuario, Jogada jogadaComputador) {

        switch (jogadaUsuario) {
            case PAPEL:
                if (PEDRA.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (TESOURA.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
            case TESOURA:
                if (PAPEL.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (PEDRA.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
            case PEDRA:
                if (TESOURA.equals(jogadaComputador)) {
                    placarJogador++;
                    status = GANHOU.getStatus();
                } else if (PAPEL.equals(jogadaComputador)) {
                    placarComputador++;
                    status = PERDEU.getStatus();
                } else {
                    empate++;
                    status = EMPATOU.getStatus();
                }
                break;
        }

        atualizaPlacar();
    }

    private void atualizaPlacar() {
        mPontosComputador.setText(String.valueOf(placarComputador));
        mPontosJogador.setText(String.valueOf(placarJogador));
        mPontosEmpate.setText(String.valueOf(empate));
        mStatusPartida.setText(status);
    }

    private Integer jogadaUsuario(View v) {
        int idResource = v.getId();
        mJogador.setImageResource(Objects.requireNonNull(mapImages.get(idResource)));

        return idResource;
    }

    public int jogadaComputador() {
        int valorRandomico = random.nextInt(3);
        int idResource = opcoesComputador.get(valorRandomico);
        mComputador.setImageResource(idResource);

        return IdsOpcoesComputador.get(valorRandomico);
    }

    private void configurarImageViews() {
        opcoesComputador = Arrays.asList(R.drawable.papel_png, R.drawable.tesoura_png, R.drawable.pedra_png);
        IdsOpcoesComputador = Arrays.asList(R.id.imageViewPapel, R.id.imageViewTesoura, R.id.imageViewPedra);
        mapImages = new HashMap<>();
        mapImages.put(R.id.imageViewPapel, R.drawable.papel_png);
        mapImages.put(R.id.imageViewTesoura, R.drawable.tesoura_png);
        mapImages.put(R.id.imageViewPedra, R.drawable.pedra_png);
        mapImages.put(R.id.imageViewComputador, R.drawable.computador_png);
        mapImages.put(R.id.imageViewJogador, R.drawable.voce);

        mPapel = findViewById(R.id.imageViewPapel);
        mTesoura = findViewById(R.id.imageViewTesoura);
        mPedra = findViewById(R.id.imageViewPedra);

        mComputador = findViewById(R.id.imageViewComputador);
        mJogador = findViewById(R.id.imageViewJogador);

    }

    enum Status {
        GANHOU("GANHOU"),
        PERDEU("PERDEU"),
        EMPATOU("EMPATOU");

        private final String status;

        public String getStatus() {
            return status;
        }

        Status(String status) {
            this.status = status;
        }
    }

    enum Jogada {
        PAPEL(R.id.imageViewPapel),
        TESOURA(R.id.imageViewTesoura),
        PEDRA(R.id.imageViewPedra);

        private final int id;

        public int getId() {
            return id;
        }

        Jogada(int id) {
            this.id = id;
        }

        public static Jogada toEnum(int id) {
            for (Jogada jogada: Jogada.values()) {
                if(jogada.getId() == id) return jogada;
            }
            throw new RuntimeException("Id inválido: "+id);
        }
    }
}
```
