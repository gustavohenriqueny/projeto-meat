import {Menu} from "./menu";
import {Avaliacao} from "./avaliacao";

export class Restaurante {
    id!: number;
    menu!: Menu;
    avaliacoes!: Avaliacao[];
    nome!: string;
    prazoEntrega!: string;
    categoria!: string;
    avaliacao!: number;
    caminhoImagem!: string;
    sobre!: string;
    horarioFuncionamento!: string;
}