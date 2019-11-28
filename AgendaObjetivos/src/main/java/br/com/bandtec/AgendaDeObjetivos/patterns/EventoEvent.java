package br.com.bandtec.AgendaDeObjetivos.patterns;

import java.util.EventObject;

import br.com.bandtec.AgendaDeObjetivos.model.Evento;

/**
 * EventoEvent
 */
public class EventoEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public EventoEvent(Evento source) {
		super(source);
	}
}