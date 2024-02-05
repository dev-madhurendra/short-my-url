import { render } from "@testing-library/react";
import MuiTypography from "."; 
import { typography_DataTestId } from "../../../utils/constants";

test("renders Typography", () => {
    const { getByTestId } = render(<MuiTypography text="hello" variant="h1" />);
    expect(getByTestId(typography_DataTestId)).toBeDefined();
});
