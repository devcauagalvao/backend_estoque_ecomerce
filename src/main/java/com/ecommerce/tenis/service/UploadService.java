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

    private static final Set<String> EXTENSOES_PERMITIDAS = Set.of("jpg", "jpeg", "png", "gif", "bmp");

    public String salvarImagem(MultipartFile file) throws IOException {
        return processarUpload(file, UPLOAD_DIR);
    }

    public String uploadProfilePicture(MultipartFile file) throws IOException {
        return processarUpload(file, "uploads/perfil");
    }

    // Método genérico para salvar imagens em um diretório específico
    private String processarUpload(MultipartFile file, String diretorio) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("O arquivo não pode estar vazio.");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new IllegalArgumentException("Nome do arquivo inválido.");
        }

        String extensao = getExtensao(fileName);
        if (!EXTENSOES_PERMITIDAS.contains(extensao.toLowerCase())) {
            throw new IllegalArgumentException("Formato de arquivo não permitido. Apenas imagens são aceitas.");
        }

        // Cria o diretório se não existir
        File directory = new File(diretorio);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Gera um nome único para evitar conflitos
        String nomeUnico = UUID.randomUUID().toString() + "." + extensao;
        Path filePath = Paths.get(diretorio, nomeUnico);

        // Salva a imagem no diretório correto
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return nomeUnico;
    }

    private String getExtensao(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex + 1);
    }
}
