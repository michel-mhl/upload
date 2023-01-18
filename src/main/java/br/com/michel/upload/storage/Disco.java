package br.com.michel.upload.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.w3c.dom.Document;

@Component
public class Disco {
	
	//@Value("${contato.disco.raiz}")
	private String raiz = "C:/Users/Michel Gonçalves/workspace/tmp/contato-disco";
	
	//@Value("${contato.disco.diretorio-arquivo}")
	private String diretorioArquivos ="arquivos";
	
	public void salvarArquivo(MultipartFile arquivo) {
		this.salvar(this.diretorioArquivos, arquivo);
	
	}
	
	public void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		System.out.println("criado");
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());	
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}	
	}
}
