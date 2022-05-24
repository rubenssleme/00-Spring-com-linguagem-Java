package avaliacao.base.serializers;

import java.io.IOException;
import java.time.LocalTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import avaliacao.base.utils.DateUtil;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

	@Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return DateUtil.toTime(jsonParser.getValueAsString());
    }
}
