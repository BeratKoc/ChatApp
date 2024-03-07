package questapp.abk.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service //IOCYE yerlestirmek icin
@AllArgsConstructor
public class ModelMapperSeviceImpl implements ModelMapperService{
	private ModelMapper modelmapper;

	@Override
	public ModelMapper forRequest() {
		this.modelmapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelmapper;
	}

	@Override
	public ModelMapper forResponse() {
		this.modelmapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelmapper;
	}
	

}
 