import {Restaurante} from "./restaurante";

export class Avaliacao {
    id!: number;
    restaurante!: Restaurante;
    nome!: string;
    avaliacao!: number;
    comentario!: string;
    dataAvaliacao!: string;
}