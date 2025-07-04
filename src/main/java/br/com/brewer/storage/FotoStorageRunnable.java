package br.com.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.brewer.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {
	
	private FotoStorage fotoStorage;
	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado, FotoStorage fotoStorage) {
		this.files = files;
		this.resultado = resultado;
		this.fotoStorage = fotoStorage;
	}
 
	@Override
	public void run() {
		 String nomeFoto = this.fotoStorage.salvarTemporariamente(files);
		 String contentType = files[0].getContentType();
		 resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
