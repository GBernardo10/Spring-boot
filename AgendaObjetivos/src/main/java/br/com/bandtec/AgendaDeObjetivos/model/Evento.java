package br.com.bandtec.AgendaDeObjetivos.model;

import java.util.ArrayList;
import java.util.Collection;
import br.com.bandtec.AgendaDeObjetivos.patterns.EventoEvent;
import br.com.bandtec.AgendaDeObjetivos.patterns.EventoListener;

/**
 * Evento
 */
public class Evento {
    private Collection<EventoListener> eventoListeners = new ArrayList<EventoListener>();

    public void enviaEvento() {
        disparaEventoChegou();
    }

    // método de suporte para testar a solução
    public void recebeEvento() {
        disparaEventoRecebido();
    }

    public synchronized void addEventoListener(EventoListener l) {
        if(!eventoListeners.contains(l)) {
            eventoListeners.add(l);
        }
    }

    public synchronized void
            removeEventoListener(EventoListener l) {

        eventoListeners.remove(l);
    }

    private void disparaEventoChegou() {
        Collection <EventoListener> tl;
        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação
            tl = (Collection)(((ArrayList)eventoListeners).clone());
        }
        EventoEvent evento = new EventoEvent(this);
        for (EventoListener t : tl) {
        	t.eventoChegou(evento);
        }
    }


    // disparaEventoRecebido() é semelhante a disparaEventoChegou()
    // Exercício: Que design pattern poderia ser usado para fatorar
    // o código comum?
    private void disparaEventoRecebido() {
        Collection <EventoListener> tl;
        synchronized (this) {
            tl = (Collection)(((ArrayList)eventoListeners).clone());
        }
        EventoEvent evento = new EventoEvent(this);
        for (EventoListener t : tl) {
        	t.eventoRecebido(evento);
        }
    }


}