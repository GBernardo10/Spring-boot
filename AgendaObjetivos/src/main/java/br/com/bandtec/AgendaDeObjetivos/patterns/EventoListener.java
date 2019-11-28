package br.com.bandtec.AgendaDeObjetivos.patterns;

import java.util.EventListener;

/**
 * EventoListener
 */
public interface EventoListener extends EventListener{
    void eventoChegou(EventoEvent e);
    void eventoRecebido(EventoEvent e);
}