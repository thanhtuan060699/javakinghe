package homework.converter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;

import homework.dto.CustomerAppointmentDTO;
import homework.entity.CustomerAppointmentEntity;

public class CustomerAppointmentConverter {
	 public CustomerAppointmentDTO convertToDTO(CustomerAppointmentEntity entity) {
		 ModelMapper modelMapper=new ModelMapper();
		 CustomerAppointmentDTO dto=modelMapper.map(entity, CustomerAppointmentDTO.class);
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		 String text = df.format(entity.getDateAppointmentE());
		 dto.setDateAppointment(text);
		 return dto;
	 }
	 public CustomerAppointmentEntity convertToEntity(CustomerAppointmentDTO dto)  {
		 ModelMapper modelMapper=new ModelMapper();
		 CustomerAppointmentEntity entity=modelMapper.map(dto, CustomerAppointmentEntity.class);
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      java.util.Date parsed;
		try {
			parsed = format.parse(dto.getDateAppointment());
			 Date sql = new Date(parsed.getTime());
			 entity.setDateAppointmentE(sql);
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
		
	 }
}
