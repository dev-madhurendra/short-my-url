import { render } from "@testing-library/react";
import MuiTypography from "."; 
import { TYPOGRAPHY_DATATESTID } from "../../../utils/constants";

test("renders Typography", () => {
    const { getByTestId } = render(<MuiTypography text="hello" variant="h1" />);
    expect(getByTestId(TYPOGRAPHY_DATATESTID)).toBeDefined();
});
