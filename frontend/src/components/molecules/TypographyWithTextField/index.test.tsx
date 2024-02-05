import { render, fireEvent } from "@testing-library/react";
import TypographyWithTextField from "./index";

describe("TypographyWithTextField", () => {
  const label = "Label";
  const color = "red";
  const placeholder = "Placeholder";
  let value = "";
  const onChange = jest.fn();
  const isPassword = false;
  const width = "200px";
  const height = 40;
  const size = "medium";
  const borderRadius = "8px";
  const variant = "body1";

  beforeEach(() => {
    onChange.mockClear();
    value = "";
  });

  it("calls onChange when input value changes", () => {
    const { getByPlaceholderText } = render(
      <TypographyWithTextField
        label={label}
        color={color}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        isPassword={isPassword}
        width={width}
        height={height}
        size={size}
        borderRadius={borderRadius}
        variant={variant}
      />
    );
    const textFieldElement = getByPlaceholderText(placeholder);
    fireEvent.change(textFieldElement, { target: { value: "New Value" } });
    expect(onChange).toHaveBeenCalledTimes(1);
    expect(onChange).toHaveBeenCalledWith("New Value");
  });

});
