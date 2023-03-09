package com.wnsdk.board.model;

public class FileInfoDto {
	
	private String saveFolder;		// 어느 폴더에 저장하는지
	private String originalFile;	// 원본 파일명
	private String saveFile;		// 실제로 저장되는 파일명
	
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public String getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	public String getSaveFile() {
		return saveFile;
	}
	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}
	
	
}
