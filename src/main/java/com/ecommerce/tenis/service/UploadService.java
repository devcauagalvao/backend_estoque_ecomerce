package com.ecommerce.tenis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.UUID;

@Service
public class UploadService {

    private static final String UPLOAD_DIR = "uploads"; 

    // Conjunto de extensões permitidas para imagens
    private static final Set<String> EXTENSOES_PERMITIDAS = Set.of("jpg", "jpeg", "png", "gif", "bmp");

    public String salvarImagem(MultipartFile file) throws IOException {
        // Verifica se o arquivo é uma imagem válida
        if (file.isEmpty()) {
            throw new IllegalArgumentException("O arquivo não pode estar vazio.");
        }

        // Obtém a extensão do arquivo
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new IllegalArgumentException("Nome do arquivo inválido.");
        }

        String extensao = getExtensao(fileName);
        if (!EXTENSOES_PERMITIDAS.contains(extensao.toLowerCase())) {
            throw new IllegalArgumentException("Formato de arquivo não permitido. Apenas imagens são aceitas.");
        }

        // Cria o diretório se ele não existir
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Gera um nome único para a imagem
        String nomeUnico = UUID.randomUUID().toString() + "." + extensao;
        Path filePath = Paths.get(UPLOAD_DIR, nomeUnico);

        // Salva o arquivo sem sobrescrever
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + nomeUnico;
    }

    // Método auxiliar para obter a extensão do arquivo
    private String getExtensao(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex + 1);
    }

    public String uploadProfilePicture(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadProfilePicture'");
    }
}
