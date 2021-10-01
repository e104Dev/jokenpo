package dev.esdras.jokenpo;

import static dev.esdras.jokenpo.GameActivity.Jogada.PAPEL;
import static dev.esdras.jokenpo.GameActivity.Jogada.PEDRA;
import static dev.esdras.jokenpo.GameActivity.Jogada.TESOURA;
import static dev.esdras.jokenpo.GameActivity.Status.EMPATOU;
import static dev.esdras.jokenpo.GameActivity.Status.GANHOU;
import static dev.esdras.jokenpo.GameActivity.Status.PERDEU;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

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

