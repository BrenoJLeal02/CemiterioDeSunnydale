# CemiterioDeSunnydale
Projeto voltado para a disciplina de Padrões de Projeto.

## Padrão State
- **`AtoState` é o Contexto**:
    - Ele é o responsável por armazenar o estado atual (`Ato estadoAtual`), que pode ser um **AtoUm**, **AtoDois** ou outros possíveis state.
    - Ele gerencia a transição de estados, usando o método `avancarParaProximoAto()` para mudar de um ato para outro.
- **`Ato` é a Interface**:
    - `Ato` define os métodos que cada ato (estado) deve implementar: `iniciar()` e `avancar()`. Cada ato é uma implementação do estado do jogo.
    - `AtoUm` e `AtoDois` são implementações concretas dessa interface, onde o comportamento de cada ato será definido separadamente.
- **Mudança de Estado**:
    - No método `avancarParaProximoAto()`, quando o jogador avança para o ato seguinte, a lógica verifica o tipo do estado atual. Se o jogo não foi completado (`jogoCompleto()`), ele avança para o próximo estado, alterando a instância de `estadoAtual`.
    - Isso é uma característica chave do padrão **State**: o objeto de contexto (`AtoState`) mantém uma referência ao estado atual (`Ato`), e quando a condição é atendida, ele transita para outro estado (de `AtoUm` para `AtoDois`, por exemplo).
- **Controle do Fluxo do Jogo**:
    - O método `jogoCompleto()` define quando o jogo deve ser considerado concluído (após o segundo ato, nesse caso). Essa lógica de verificação também está de acordo com o padrão **State**, onde o comportamento do jogo é alterado dependendo do estado atual.
- **Finalização do Jogo**:
    - Quando o jogo é completado, você chama o método `finalizarJogo()`, o que mostra como a transição de estados pode resultar em uma ação final, como salvar o progresso ou exibir uma mensagem de conclusão.