import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class LocalStorageService {

    constructor() {
    }

    setItem(chave: string, valor: any) {
        localStorage.setItem(chave, JSON.stringify(valor));
    }

    getItem(chave: string) {
        let valor = localStorage.getItem(chave);
        return valor ? JSON.parse(valor) : null;
    }

    removeItem(chave: string) {
        localStorage.removeItem(chave);
    }

}
