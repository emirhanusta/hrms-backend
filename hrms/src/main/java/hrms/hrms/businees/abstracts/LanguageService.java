package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.model.Language;

public interface LanguageService {
	Result add(Language language);
	Result delete(Language language);
	DataResult<List<Language>> getAll();
}
