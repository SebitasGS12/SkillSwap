package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.repository.IChatUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatUsuarioService {
      private final IChatUsuarioRepository rechus;

    public int ultimoId(){
        List<ChatUsuario> lista = rechus.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getChatUsuarioId()+1 ;
    }

    public List<ChatUsuario> findAll(){
        return rechus.findAll();
    }
           public ChatUsuario findById(int id){
        return  rechus.findById(id).orElseThrow();
    }

    public ChatUsuario saveChatUsuario(ChatUsuario chatUsuario) {
        if (chatUsuario.getChatUsuarioId() == null ){
            chatUsuario.setChatUsuarioId(ultimoId());
        }
        return rechus.save(chatUsuario);
    }
    public void delteChatUsuarioById(Integer id) {
        rechus.deleteById(id);
    }
    public ChatUsuario nullChatUsuario() {
        ChatUsuario chatUsuario = new ChatUsuario();
        chatUsuario.setChatUsuarioId(null);
        return chatUsuario;
    }
    public ChatUsuario newChatUsuario() {
        ChatUsuario chatUsuario = new ChatUsuario();
        chatUsuario.setChatUsuarioId(ultimoId());
        return chatUsuario;
    }
}
