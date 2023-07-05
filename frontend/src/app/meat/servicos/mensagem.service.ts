import {Injectable} from '@angular/core';
import {MessageService} from "primeng/api";

@Injectable({
    providedIn: 'root'
})
export class MensagemService {

    constructor(
        private messageService: MessageService) {
    }

    exibirMensagem(severidade: string, titulo: string, mensagem: string) {
        this.messageService.add({
            severity: severidade,
            summary: titulo,
            detail: mensagem
        });
        setTimeout(() => {
            this.messageService.clear()
        }, 4000);
    }
}
